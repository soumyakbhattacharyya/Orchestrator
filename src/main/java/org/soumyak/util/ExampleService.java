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
package org.soumyak.util;

import org.springframework.stereotype.Component;


/**
 * {@link Service} with hard-coded input data.
 */
@Component
public class ExampleService implements Service {
	
	/**
	 * Reads next record from input
	 */
	public String getMessage() {
		return "Hello world!";
		//TODO Need to make sure that this method is appropriately tested		
	}

}
