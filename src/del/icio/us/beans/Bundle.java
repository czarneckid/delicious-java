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
 * Bundle
 *
 * @author David Czarnecki
 * @version $Id: Bundle.java,v 1.6 2007/01/19 00:14:43 czarneckid Exp $
 * @since 1.9
 */
public class Bundle {

    private String name;
    private String tags;

    /**
     * Create a new bundle with a bundle name and a space separated list of tags
     *
     * @param name Bundle name
     * @param tags List of tags
     */
    public Bundle(String name, String tags) {
        this.name = name;
        this.tags = tags;
    }

    /**
     * Get the name of this bundle
     *
     * @return Name of this bundle
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this bundle
     *
     * @param name Name of this bundle
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the space separated list of tags for this bundle
     *
     * @return Space separated list of tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * Set the list of tags for this bundle
     *
     * @param tags List of tags for this bundle
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * Get the list of tags as a <code>String[]</code>
     *
     * @return List of tags as a <code>String []</code>
     */
    public String[] getTagsAsArray() {
        if (tags == null) {
            return new String[0];
        }

        return tags.split(" ");
    }

    /**
     * Object as name:tags string
     *
     * @return name:tags
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(name).append(":").append(tags);

        return result.toString();
    }
}
