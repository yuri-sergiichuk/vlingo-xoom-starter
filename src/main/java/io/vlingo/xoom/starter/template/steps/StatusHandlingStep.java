// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.xoom.starter.template.steps;

import io.vlingo.xoom.starter.template.TemplateGenerationException;
import io.vlingo.xoom.starter.template.TemplateGenerationContext;

public class StatusHandlingStep implements TemplateGenerationStep {

    @Override
    public void process(final TemplateGenerationContext context) {
        try {
            final Integer status = context.process().waitFor();
            StatusHandler.forStatus(status).handle(context);
        } catch (InterruptedException e) {
            throw new TemplateGenerationException(e);
        }
    }

}
