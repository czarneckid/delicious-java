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
package del.icio.us.beans;

/**
 * Tag
 * 
 * @author David Czarnecki
 * @version $Id: Tag.java,v 1.4 2007/01/19 00:14:43 czarneckid Exp $
 * @since 1.0
 */
public class Tag {

    private int count;
    private String tag;

    /**
     * Construct a new tag
     *
     * @param count Number of links for tag
     * @param tag Tag name
     */
    public Tag(int count, String tag) {
        this.count = count;
        this.tag = tag;
    }

    /**
     * Get number of links for tag
     *
     * @return Number of links for tag
     */
    public int getCount() {
        return count;
    }

    /**
     * Set number of links for tag
     *
     * @param count Number of links for tag
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Get tag name
     *
     * @return Tag name
     */
    public String getTag() {
        return tag;
    }

    /**
     * Set tag name
     *
     * @param tag Tag name
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Object as count:tag string
     *
     * @return count:tag
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(count).append(":").append(tag);

        return result.toString();
    }
}