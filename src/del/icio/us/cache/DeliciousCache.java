/**
 * Copyright (c) 2004-2007, David A. Czarnecki
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *      this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the "David A. Czarnecki" nor the names of
 * its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package del.icio.us.cache;

import del.icio.us.Delicious;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A cache for del.icio.us requests to get recent posts.
 *
 * @author Simon Brown
 * @version $Id: DeliciousCache.java,v 1.3 2007/01/19 00:14:43 czarneckid Exp $
 */
public class DeliciousCache {

    /**
     * the map of cached post lists
     */
    private Map map;

    /**
     * the singleton instance of this class
     */
    private static final DeliciousCache INSTANCE = new DeliciousCache();

    /**
     * the maximum number of recent posts
     */
    private static final int MAX_RECENT_POSTS = 100;

    /**
     * Gets the singleton instance.
     *
     * @return a DeliciousCache instance
     */
    public static DeliciousCache getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance, private to enfore singleton pattern.
     */
    private DeliciousCache() {
        this.map = new HashMap();
    }

    /**
     * Gets a list of recent posts for ths given criteria. If the posts that were
     * last retrieved are more than timeout milliseconds old, they are refreshed
     * from del.icio.us.
     *
     * @param username the del.icio.us username
     * @param password the del.icio.us password
     * @param count    the number of recent posts to get
     * @param tag      a filter tag (optional, can be null)
     * @param timeout  the timeout in milliseconds of the cached data
     * @return a Collection of Post objects
     */
    public synchronized List getRecentPosts(String username, String password, int count, String tag, long timeout) {
        CachedPosts posts = (CachedPosts) map.get(buildKey(username, tag));
        if (posts == null || posts.hasExpired(timeout)) {
            Delicious delicious = new Delicious(username, password);
            List coll = delicious.getRecentPosts(tag, MAX_RECENT_POSTS);
            posts = new CachedPosts(coll);
            map.put(buildKey(username, tag), posts);
        }

        return posts.getPosts(count);
    }

    /**
     * Builds a key to be used when storing/retrieving items from the cache, of
     * the form : username[/tag]
     *
     * @param username the del.icio.us username
     * @param tag      the filter tag
     * @return a unique string identifying a username and tag
     */
    private String buildKey(String username, String tag) {
        if (tag == null || tag.trim().length() == 0) {
            return username;
        } else {
            return username + "/" + tag;
        }
    }
}
