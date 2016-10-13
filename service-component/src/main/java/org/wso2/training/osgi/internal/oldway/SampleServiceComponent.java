/*
 * Copyright 2016 WSO2, Inc. http://www.wso2.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.training.osgi.internal.oldway;

import org.osgi.service.component.ComponentContext;
import org.wso2.training.osgi.Hello;

/**
 * @scr.component name="org.wso2.training.osgi.internal.oldway.SampleServiceComponent"
 * immediate="true"
 * @scr.reference name="org.wso2.training.osgi.Hello"
 * interface="org.wso2.training.osgi.Hello"
 * cardinality="1..1" policy="dynamic" bind="setHelloService"
 * unbind="unsetHelloService"
 */
public class SampleServiceComponent {
    private Hello hello;

    protected void activate(ComponentContext context) {
        System.out.println("Start Activating Service Component");
        //System.out.println(hello.sayHello());
        System.out.println(hello.sayHello("WSO2"));
    }

    protected void deactivate(ComponentContext context) {
        System.out.println("Deactivating Service Component");

    }

    protected void setHelloService(Hello hello) {
        this.hello = hello;
    }

    protected void unsetHelloService(Hello hello) {
        this.hello = null;
    }

}
