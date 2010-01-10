/**
 * Copyright (c) 2004, David A. Czarnecki
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

import junit.framework.TestCase;

import java.util.ArrayList;

import del.icio.us.beans.Post;

/**
 * Tests for the CachedPosts class.
 *
 * @author Simon Brown
 * @version $Id: CachedPostsTest.java,v 1.2 2006/05/08 12:59:17 czarneckid Exp $
 */
public class CachedPostsTest extends TestCase {

    private CachedPosts posts;

    /**
     * Tests construction of the class.
     */
    public void testConstruction() {
        posts = new CachedPosts(null);
        assertTrue(posts.getPosts().isEmpty());

        ArrayList list = new ArrayList();
        Post post1 = new Post("href1", "description1", "extended1", "href1Hash", "tag1", "time1", true);
        Post post2 = new Post("href2", "description2", "extended2", "href2Hash", "tag2", "time2", true);
        Post post3 = new Post("href3", "description3", "extended3", "href3Hash", "tag3", "time3", true);
        list.add(post1);
        list.add(post2);
        list.add(post3);
        posts = new CachedPosts(list);
        assertEquals(3, posts.getPosts().size());
        assertTrue(posts.getPosts().contains(post1));
        assertTrue(posts.getPosts().contains(post2));
        assertTrue(posts.getPosts().contains(post3));
    }

    /**
     * Tests getting a subset of the posts.
     */
    public void testGetPosts() {
        ArrayList list = new ArrayList();
        Post post1 = new Post("href1", "description1", "extended1", "href1Hash", "tag1", "time1", true);
        Post post2 = new Post("href2", "description2", "extended2", "href2Hash", "tag2", "time2", true);
        Post post3 = new Post("href3", "description3", "extended3", "href3Hash", "tag3", "time3", true);
        list.add(post1);
        list.add(post2);
        list.add(post3);
        posts = new CachedPosts(list);
        assertEquals(3, posts.getPosts(-1).size());
        assertEquals(3, posts.getPosts(0).size());
        assertEquals(1, posts.getPosts(1).size());
        assertEquals(2, posts.getPosts(2).size());
        assertEquals(3, posts.getPosts(3).size());
        assertTrue(posts.getPosts(2).contains(post1));
        assertTrue(posts.getPosts(2).contains(post2));
        assertFalse(posts.getPosts(2).contains(post3));
    }

    /**
     * Tests the timeout.
     */
    public void testHasExpired() {
        posts = new CachedPosts(null);
        assertFalse(posts.hasExpired(1000));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        assertTrue(posts.hasExpired(1000));
        assertFalse(posts.hasExpired(2000));
    }
}
