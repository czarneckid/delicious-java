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

import del.icio.us.DeliciousUtils;

import java.util.Date;

/**
 * Post
 *
 * @author David Czarnecki
 * @version $Id: Post.java,v 1.8 2008/07/30 00:11:22 czarneckid Exp $
 * @since 1.0
 */
public class Post {

    private String href;
    private String description;
    private String hash;
    private String tag;
    private String time;
    private String extended;
    private int others;
    private boolean shared;

    /**
     * Construct a new Post
     *
     * @param href        Link
     * @param description Description of link
     * @param hash        Hash of link
     * @param tag         Space-delimited set of tags
     * @param time        Time when link added
     * @param shared      Whether or not the post is shared
     */
    public Post(String href, String description, String extended, String hash, String tag, String time, boolean shared, int others) {
        this.href = href;
        this.description = description;
        this.extended = extended;
        this.hash = hash;
        this.tag = tag;
        this.time = time;
        this.shared = shared;
        this.others = others;
    }
    
    /**
     * Construct a new Post
     *
     * @param href        Link
     * @param description Description of link
     * @param hash        Hash of link
     * @param tag         Space-delimited set of tags
     * @param time        Time when link added
     * @param shared      Whether or not the post is shared
     */
    public Post(String href, String description, String extended, String hash, String tag, String time, boolean shared) {
       this(href, description, extended, hash, tag, time, shared, -1);
    }

    /**
     * Get link of post
     *
     * @return Link
     */
    public String getHref() {
        return href;
    }

    /**
     * Set link for post
     *
     * @param href Link
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * Get description of link
     *
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description for post
     *
     * @param description Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get hash of link
     *
     * @return Hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * Set hash for post
     *
     * @param hash Hash
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * Get tag(s) for link
     *
     * @return Space-delimited set of tag(s) for link
     */
    public String getTag() {
        return tag;
    }

    /**
     * Set tag(s) for post
     *
     * @param tag Space-delimited set of tag(s) for link
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Get time link posted
     *
     * @return Link posted time
     */
    public String getTime() {
        return time;
    }

    /**
     * Set time posted as UTC-time (yyyy-MM-ddTHH:mm:ssZ)
     *
     * @param time Posted time as UTC-time (yyyy-MM-ddTHH:mm:ssZ)
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Return a {@link Date} from the UTC time for this post
     *
     * @return {@link Date} from the UTC time for this post
     *         or <code>null</code> if the time is not in proper UTC format
     */
    public Date getTimeAsDate() {
        return DeliciousUtils.getDateFromUTCString(time);
    }

    /**
     * Get extended description for post
     *
     * @return Extended description
     */
    public String getExtended() {
        return extended;
    }

    /**
     * Set extended description for post
     *
     * @param extended Extended description
     */
    public void setExtended(String extended) {
        this.extended = extended;
    }

    /**
     * Get whether or not the post is shared
     *
     * @return <code>true</code> if shared, <code>false</code> otherwise
     */
    public boolean isShared() {
        return shared;
    }

    /**
     * Set whether or not the post is shared
     *
     * @param shared <code>true</code> if shared, <code>false</code> otherwise
     */
    public void setShared(boolean shared) {
        this.shared = shared;
    }

    /**
     * Get number of others for this post
     *
     * @return Extended description
     */
    public int getOthers() {
        return others;
    }

    /**
     * Set extended description for post
     *
     * @param extended Extended description
     */
    public void setOthers(int others) {
        this.others = others;
    }
    
    /**
     * Object as href:description:extended:hash:tag:time string
     *
     * @return href:description:extended:hash:tag:time
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(href).append(":").append(description).append(":").append(extended).append(":").append(hash).append(":")
                .append(tag).append(":").append(time).append(":").append(shared).append(":").append(others);

        return result.toString();
    }

    /**
     * Split the tags
     *
     * @param splitRegex Split regular expression
     * @return Tags as <code>String[]</code>
     * @since 1.6
     */
    public String[] getTagsAsArray(String splitRegex) {
        return tag.split(splitRegex);
    }

    /**
     * Check to see if this {@link Post} object equals another (uses href for equality)
     *
     * @param obj {@link Post} object
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise
     */
    public boolean equals(Object obj) {
        if (obj instanceof Post) {
            return getHref().equals(((Post) obj).getHref());
        }

        return super.equals(obj);
    }
    
    /**
     * Method to calculate hash code based on <code>{@link #getHref()}</code>
     */
    public int hashCode() {
    	int result = 3;
    	result = 73 * result + (getHref() != null ? getHref().hashCode() : 0);
    	
    	return result;
    }
}