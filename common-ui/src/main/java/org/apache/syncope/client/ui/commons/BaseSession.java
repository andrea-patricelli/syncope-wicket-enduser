/*
 *  Copyright (C) 2020 Tirasa (info@tirasa.net)
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.syncope.client.ui.commons;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.syncope.common.lib.to.UserTO;

public interface BaseSession {

    enum Error {
        SESSION_EXPIRED("error.session.expired", "Session expired: please login again"),
        AUTHORIZATION("error.authorization", "Insufficient access rights when performing the requested operation"),
        REST("error.rest", "There was an error while contacting the Core server");

        private final String key;

        private final String fallback;

        Error(final String key, final String fallback) {
            this.key = key;
            this.fallback = fallback;
        }

        public String key() {
            return key;
        }

        public String fallback() {
            return fallback;
        }
    }

    void setDomain(String domain);

    String getDomain();

    <T> T getAnonymousService(Class<T> serviceClass);

    <T> T getService(Class<T> serviceClass);

    <T> T getService(String etag, Class<T> serviceClass);

    <T> void resetClient(Class<T> service);

    void invalidate();

    boolean isAuthenticated();

    UserTO getSelfTO();

    FastDateFormat getDateFormat();

    /**
     * Extract and localize (if translation available) the actual message from the given exception; then, report it
     * via {@link org.apache.wicket.Session#error(java.io.Serializable)}.
     *
     * @see org.apache.syncope.client.lib.RestClientExceptionMapper
     *
     * @param e raised exception
     */
    void onException(Exception e);
}
