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
package org.wso2.training.osgi.internal.newway;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.training.osgi.Hello;

@Component(
        name = "org.wso2.training.osgi.internal.newway.SampleServiceComponent",
        immediate = true,
        property = {
                "componentName=NewSampleSericeComponent"
        }
)
public class SampleServiceComponent {
    private Hello hello;

    @Activate
    protected void activate(ComponentContext context) {
        System.out.println("Start Activating Service Component");
        //System.out.println(hello.sayHello());
        System.out.println(hello.sayHello("WSO2"));
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {
        System.out.println("Deactivating Service Component");

    }

    @Reference(
            name = "hello-setter",
            service = Hello.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetHelloService"
    )
    protected void setHelloService(Hello hello) {
        this.hello = hello;
    }

    protected void unsetHelloService(Hello hello) {
        this.hello = null;
    }

}
