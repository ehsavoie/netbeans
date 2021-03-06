/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.test.languages;

import junit.framework.Test;
import org.netbeans.junit.NbModuleSuite;
import org.netbeans.test.lib.BasicOpenFileTest;

/**
 *
 * @author Jindrich Sedek
 */
public class OpenProjectFileTest extends BasicOpenFileTest {
    private static final String projectName = "OpenFileProj";
    public OpenProjectFileTest(String str) {
        super(str);
    }

    public static Test suite(){
        return NbModuleSuite.allModules(OpenProjectFileTest.class);
    }
    
    @Override
    public void setUp() throws Exception{
        super.setUp();
        openDataProjects(projectName);
    }
    
    public void testBAT()throws Exception{
        openFile(projectName, "sample.bat");
        edit("FOR %%b in (A, B, C) DO IF %%b == B echo B is in the set!");
        closeFile();
    }

    public void testDIFF()throws Exception{
        openFile(projectName, "sample.diff");
        edit("0a1,6");
        closeFile();
    }
    
    public void testSH()throws Exception{
        openFile(projectName, "sample.sh");
        edit("ls -l | sed -e 's/[aeio]/u/g'");
        closeFile();
    }
    
    public void testMF()throws Exception{
        openFile(projectName, "sample.mf");
        edit("OpenIDE-Module: org.netbeans.modules.web.core.syntax/1");
        closeFile();
    }
    
}
