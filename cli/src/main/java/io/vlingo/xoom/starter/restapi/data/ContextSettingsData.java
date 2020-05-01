package io.vlingo.xoom.starter.restapi.data;

import io.vlingo.xoom.starter.task.Property;

import java.util.Arrays;
import java.util.List;

public class ContextSettingsData {

    public final String groupId;
    public final String artifactId;
    public final String artifactVersion;
    public final String packageName;
    public final String xoomVersion;

    public ContextSettingsData(final String groupId,
                               final String artifactId,
                               final String artifactVersion,
                               final String packageName,
                               final String xoomVersion) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.artifactVersion = artifactVersion;
        this.packageName = packageName;
        this.xoomVersion = xoomVersion;
    }

    List<String> toArguments() {
        return Arrays.asList(
                Property.GROUP_ID.literal(),
                groupId,
                Property.ARTIFACT_ID.literal(),
                artifactId,
                Property.VERSION.literal(),
                artifactVersion,
                Property.PACKAGE.literal(),
                packageName,
                Property.XOOM_SERVER_VERSION.literal(),
                xoomVersion
        );
    }
}
