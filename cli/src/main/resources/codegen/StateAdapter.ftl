package ${packageName};

<#list imports as import>
import ${import.qualifiedClassName};
</#list>

import io.vlingo.common.serialization.JsonSerialization;
import io.vlingo.symbio.Metadata;
import io.vlingo.symbio.State.TextState;
import io.vlingo.symbio.StateAdapter;

public class ${stateClass}Adapter implements StateAdapter<${stateClass},TextState> {

  @Override
  public int typeVersion() {
    return 1;
  }

  @Override
  public ${stateClass} fromRawState(final TextState raw) {
    return JsonSerialization.deserialized(raw.data, raw.typed());
  }

  @Override
  public <ST> ST fromRawState(final TextState raw, final Class<ST> stateType) {
    return JsonSerialization.deserialized(raw.data, stateType);
  }

  @Override
  public TextState toRawState(final String id, final ${stateClass} state, final int stateVersion, final Metadata metadata) {
    final String serialization = JsonSerialization.serialized(state);
    return new TextState(id, ${stateClass}.class, typeVersion(), serialization, stateVersion, metadata);
  }
}
