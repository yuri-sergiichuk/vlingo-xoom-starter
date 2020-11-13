// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.
package io.vlingo.xoom.starter.task.projectgeneration.steps;

import io.vlingo.xoom.codegen.parameter.CodeGenerationParameters;
import io.vlingo.xoom.starter.task.TaskExecutionContext;
import io.vlingo.xoom.starter.task.steps.TaskExecutionStep;

public class CodeGenerationParameterValidationStep implements TaskExecutionStep {

    @Override
    public void process(final TaskExecutionContext context) {
        final CodeGenerationParameters parameters = context.codeGenerationParameters();
        //TODO: Validate parameters here
    }
}