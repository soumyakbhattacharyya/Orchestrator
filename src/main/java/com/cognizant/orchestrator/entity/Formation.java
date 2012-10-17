/*
 * Copyright 2012 Cognizant.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognizant.orchestrator.entity;

import com.cognizant.jpaas.cloud.datamodel.cloud.VirtualMachineProductType;
import java.util.Set;
import java.util.UUID;

/**
 * Formation is a runtime representation of a deployable configuration & task
 * sequences
 * @author 239913
 */
public class Formation {
    
    private UUID id;
    private String label;
    
    // Encapsulate infrastruture
    
    VirtualMachineProductType resource;
    Set<VirtualMachineProductType> resources;
    
    // Encapsulate job options for a specific job group
    
    
}
