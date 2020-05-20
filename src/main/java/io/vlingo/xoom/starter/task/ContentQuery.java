// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.xoom.starter.task;

import io.vlingo.xoom.starter.task.template.code.CodeTemplateStandard;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class ContentQuery {

    public static String findClassName(final Object subject, final List<Content> contents) {
        return findClassNames(subject, contents).stream().findFirst().get();
    }

    public static List<String> findClassNames(final Object subject, final List<Content> contents) {
        return contents.stream().filter(content -> content.isAbout(subject))
                .map(content -> retrieveFilename(content.file))
                .collect(Collectors.toList());
    }

    public static String findFullyQualifiedClassName(final CodeTemplateStandard standard, final List<Content> contents) {
        return findFullyQualifiedClassNames(standard, contents).stream().findFirst().get();
    }

    public static List<String> findFullyQualifiedClassNames(final Object subject, final List<Content> contents) {
        return contents.stream().filter(content -> content.isAbout(subject))
                .map(content -> {
                    final String className = retrieveFilename(content.file);
                    final String packageName = retrievePackage(content.text);
                    return String.format("%s.%s", packageName, className);
                }).collect(Collectors.toList());
    }

    public static String findFullyQualifiedClassName(final Object subject, final String className, final List<Content> contents) {
        return findFullyQualifiedClassNames(subject, contents).stream()
                .filter(qualifiedClassName -> qualifiedClassName.endsWith("." + className))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    private static String retrieveFilename(final File file) {
        return FilenameUtils.removeExtension(file.getName());
    }

    private static String retrievePackage(final String text) {
        final int packageStartIndex = text.indexOf("package");
        final int packageEndIndex = text.indexOf(";");
        return text.substring(packageStartIndex + 8, packageEndIndex);
    }
}