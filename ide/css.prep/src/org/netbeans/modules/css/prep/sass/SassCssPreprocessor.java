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
package org.netbeans.modules.css.prep.sass;

import org.netbeans.api.project.Project;
import org.netbeans.modules.css.prep.process.SassProcessor;
import org.netbeans.modules.css.prep.util.BaseCssPreprocessor;
import org.netbeans.modules.web.common.api.CssPreprocessors;
import org.netbeans.modules.web.common.spi.CssPreprocessorImplementation;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders({
    @ServiceProvider(service = CssPreprocessorImplementation.class, path = CssPreprocessors.PREPROCESSORS_PATH, position = 100),
    @ServiceProvider(service = SassCssPreprocessor.class, path = CssPreprocessors.PREPROCESSORS_PATH, position = 100),
})
public final class SassCssPreprocessor extends BaseCssPreprocessor {

    public static final String IDENTIFIER = "SASS"; // NOI18N


    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @NbBundle.Messages("SassCssPreprocessor.displayName=Sass")
    @Override
    public String getDisplayName() {
        return Bundle.SassCssPreprocessor_displayName();
    }

    @Override
    public void process(Project project, FileObject fileObject, String originalName, String originalExtension) {
        new SassProcessor(this).process(project, fileObject, originalName, originalExtension);
    }

}
