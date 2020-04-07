// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.xoom.starter;

import io.vlingo.xoom.starter.template.TemplateGenerationContext;
import io.vlingo.xoom.starter.template.TemplateGenerator;

public class Initializer {

    public static void main(final String[] args) throws InterruptedException {
        TemplateGenerator.start(new TemplateGenerationContext());
        System.exit(0);
    }

}