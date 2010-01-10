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
package del.icio.us.tagext;

import del.icio.us.DeliciousException;
import del.icio.us.cache.DeliciousCache;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;
import java.util.ArrayList;

/**
 * JSP tag to get a list of recent posts from the del.icio.us service.
 *
 * @author Simon Brown
 * @version $Id: GetRecentPostsTag.java,v 1.5 2007/01/19 00:14:43 czarneckid Exp $
 */
public class GetRecentPostsTag extends TagSupport {

    /**
     * the name of the variable to inject back into the JSP page
     */
    private String var;

    /**
     * the del.icio.us username
     */
    private String username;

    /**
     * the del.icio.us password
     */
    private String password;

    /**
     * the count of recent posts to retrieve
     */
    private int count = 10;

    /**
     * a filtering tag (optional)
     */
    private String tag = null;

    /**
     * the timeout after which cached del.icio.us should be re-retrieved
     */
    private long timeout = THIRTY_MINUTES;

    private static final int THIRTY_MINUTES = 1000 * 60 * 30;

    /**
     * Called when the opening tag is encountered on the page.
     *
     * @return Tag.SKIP_BODY, to skip (empty) body execution
     * @throws JspException if something goes wrong
     */
    public int doStartTag() throws JspException {
        List posts = new ArrayList();
        try {
            posts = DeliciousCache.getInstance().getRecentPosts(username, password, count, tag, timeout);
        } catch (DeliciousException de) {
          // do nothing, the error has already been logged by the Delicious class
        }
        pageContext.setAttribute(var, posts, PageContext.PAGE_SCOPE);

        return Tag.EVAL_BODY_INCLUDE;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

}
