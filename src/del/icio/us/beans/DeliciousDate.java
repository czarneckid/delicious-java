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
 * DeliciousDate
 *
 * @author David Czarnecki
 * @version $Id: DeliciousDate.java,v 1.4 2007/01/19 00:14:43 czarneckid Exp $
 * @since 1.0
 */
public class DeliciousDate {

    private int count;
    private String date;

    /**
     * Construct a new date
     *
     * @param count Number of links on date
     * @param date Date (should be yyyy-MM-dd format, but not enforced)
     */
    public DeliciousDate(int count, String date) {
        this.count = count;
        this.date = date;
    }

    /**
     * Get number of links for date
     *
     * @return Number of links for date
     */
    public int getCount() {
        return count;
    }

    /**
     * Set number of links for date
     *
     * @param count Number of links for date
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Get date
     *
     * @return Date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set date (should be yyyy-MM-dd format, but not enforced)
     *
     * @param date Date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Object as count:date string
     *
     * @return count:date
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(count).append(":").append(date);

        return result.toString();
    }
}