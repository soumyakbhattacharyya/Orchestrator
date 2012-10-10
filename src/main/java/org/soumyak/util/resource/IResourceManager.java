/**
 * Copyright 2012 Soumyak Bhattacharyya
 * This project includes software developed by Soumyak Bhattacharyya: https://github.com/iamsoumyak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.soumyak.util.resource;

import java.util.List;

/*
 * Manages resource including spawning, listing and stopping
 */
public interface IResourceManager {
	
	boolean HAS_SPAWNED = Boolean.TRUE;
	boolean HAS_TERMINATED = Boolean.TRUE;
	
	/**
	 * Spawns a new cloud VM 
	 * @return ifStarted
	 */
	public boolean spawnVM();
	
	/**
	 * Terminates the VM
	 * @return ifStopped
	 */
	public boolean stopVM();
	
	/**
	 * Get a list of VMs
	 * @return listOfVMs
	 */
	public List getVM(); 

}
