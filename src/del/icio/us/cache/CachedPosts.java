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

import java.util.ArrayList;
import java.util.List;

/**
 * A wrapper for posts back from the del.icio.us service.
 *
 * @author Simon Brown
 * @version $Id: CachedPosts.java,v 1.3 2007/01/19 00:14:43 czarneckid Exp $
 */
class CachedPosts {

    /**
     * the List of Post objects
     */
    private List posts;

    /**
     * the date/time that the posts were retrieved
     */
    private long date;

    /**
     * Creates a new instance.
     *
     * @param posts the List of Post objects
     */
    CachedPosts(List posts) {
        if (posts == null) {
            this.posts = new ArrayList();
        } else {
            this.posts = posts;
        }
        this.date = System.currentTimeMillis();
    }

    /**
     * Gets the collection of Post objects.
     *
     * @return a List of Post objects
     */
    List getPosts() {
        return new ArrayList(posts);
    }

    /**
     * Gets the collection of Post objects.
     *
     * @param count the number of posts to retrieve
     * @return a List of Post objects
     */
    List getPosts(int count) {
        if (count > 0 && posts.size() > count) {
            return posts.subList(0, count);
        } else {
            return getPosts();
        }
    }

    /**
     * Determines whether this list of posts has expired.
     *
     * @param timeout the timeout in milliseconds
     * @return true if the current time > posts retrieved time + timeout
     */
    boolean hasExpired(long timeout) {
        return System.currentTimeMillis() > (this.date + timeout);
    }
}
