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
package org.apache.syncope.client.ui.commons.status;

import java.io.Serializable;
import org.apache.syncope.common.lib.to.AnyTO;
import org.apache.syncope.common.lib.to.ConnObjectTO;

public class ConnObjectWrapper implements Serializable {

    private static final long serialVersionUID = 9083721948999924299L;

    private final AnyTO any;

    private final String resource;

    private final ConnObjectTO connObjectTO;

    public ConnObjectWrapper(final AnyTO any, final String resource, final ConnObjectTO connObjectTO) {
        this.any = any;
        this.resource = resource;
        this.connObjectTO = connObjectTO;
    }

    public AnyTO getAny() {
        return any;
    }

    public String getResource() {
        return resource;
    }

    public ConnObjectTO getConnObjectTO() {
        return connObjectTO;
    }

}
