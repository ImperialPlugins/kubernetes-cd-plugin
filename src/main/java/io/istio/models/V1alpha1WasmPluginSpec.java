/*
 * Kubernetes
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.21.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.istio.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.istio.models.V1alpha1WasmPluginSpecMatch;
import io.istio.models.V1alpha1WasmPluginSpecVmConfig;
import io.istio.models.V1alpha3DestinationRuleSpecWorkloadSelector;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Extend the functionality provided by the Istio proxy through WebAssembly filters. See more details at: https://istio.io/docs/reference/config/proxy_extensions/wasm-plugin.html
 */
@ApiModel(description = "Extend the functionality provided by the Istio proxy through WebAssembly filters. See more details at: https://istio.io/docs/reference/config/proxy_extensions/wasm-plugin.html")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-12-20T14:22:47.686Z[Etc/UTC]")
public class V1alpha1WasmPluginSpec {
  /**
   * Gets or Sets imagePullPolicy
   */
  @JsonAdapter(ImagePullPolicyEnum.Adapter.class)
  public enum ImagePullPolicyEnum {
    UNSPECIFIED_POLICY("UNSPECIFIED_POLICY"),
    
    IFNOTPRESENT("IfNotPresent"),
    
    ALWAYS("Always");

    private String value;

    ImagePullPolicyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ImagePullPolicyEnum fromValue(String value) {
      for (ImagePullPolicyEnum b : ImagePullPolicyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ImagePullPolicyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ImagePullPolicyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ImagePullPolicyEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ImagePullPolicyEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_IMAGE_PULL_POLICY = "imagePullPolicy";
  @SerializedName(SERIALIZED_NAME_IMAGE_PULL_POLICY)
  private ImagePullPolicyEnum imagePullPolicy;

  public static final String SERIALIZED_NAME_IMAGE_PULL_SECRET = "imagePullSecret";
  @SerializedName(SERIALIZED_NAME_IMAGE_PULL_SECRET)
  private String imagePullSecret;

  public static final String SERIALIZED_NAME_MATCH = "match";
  @SerializedName(SERIALIZED_NAME_MATCH)
  private List<V1alpha1WasmPluginSpecMatch> match = null;

  /**
   * Determines where in the filter chain this &#x60;WasmPlugin&#x60; is to be injected.
   */
  @JsonAdapter(PhaseEnum.Adapter.class)
  public enum PhaseEnum {
    UNSPECIFIED_PHASE("UNSPECIFIED_PHASE"),
    
    AUTHN("AUTHN"),
    
    AUTHZ("AUTHZ"),
    
    STATS("STATS");

    private String value;

    PhaseEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PhaseEnum fromValue(String value) {
      for (PhaseEnum b : PhaseEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PhaseEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PhaseEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PhaseEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PhaseEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PHASE = "phase";
  @SerializedName(SERIALIZED_NAME_PHASE)
  private PhaseEnum phase;

  public static final String SERIALIZED_NAME_PLUGIN_CONFIG = "pluginConfig";
  @SerializedName(SERIALIZED_NAME_PLUGIN_CONFIG)
  private Object pluginConfig;

  public static final String SERIALIZED_NAME_PLUGIN_NAME = "pluginName";
  @SerializedName(SERIALIZED_NAME_PLUGIN_NAME)
  private String pluginName;

  public static final String SERIALIZED_NAME_PRIORITY = "priority";
  @SerializedName(SERIALIZED_NAME_PRIORITY)
  private Object priority;

  public static final String SERIALIZED_NAME_SELECTOR = "selector";
  @SerializedName(SERIALIZED_NAME_SELECTOR)
  private V1alpha3DestinationRuleSpecWorkloadSelector selector;

  public static final String SERIALIZED_NAME_SHA256 = "sha256";
  @SerializedName(SERIALIZED_NAME_SHA256)
  private String sha256;

  public static final String SERIALIZED_NAME_URL = "url";
  @SerializedName(SERIALIZED_NAME_URL)
  private String url;

  public static final String SERIALIZED_NAME_VERIFICATION_KEY = "verificationKey";
  @SerializedName(SERIALIZED_NAME_VERIFICATION_KEY)
  private String verificationKey;

  public static final String SERIALIZED_NAME_VM_CONFIG = "vmConfig";
  @SerializedName(SERIALIZED_NAME_VM_CONFIG)
  private V1alpha1WasmPluginSpecVmConfig vmConfig;


  public V1alpha1WasmPluginSpec imagePullPolicy(ImagePullPolicyEnum imagePullPolicy) {
    
    this.imagePullPolicy = imagePullPolicy;
    return this;
  }

   /**
   * Get imagePullPolicy
   * @return imagePullPolicy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ImagePullPolicyEnum getImagePullPolicy() {
    return imagePullPolicy;
  }


  public void setImagePullPolicy(ImagePullPolicyEnum imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
  }


  public V1alpha1WasmPluginSpec imagePullSecret(String imagePullSecret) {
    
    this.imagePullSecret = imagePullSecret;
    return this;
  }

   /**
   * Credentials to use for OCI image pulling.
   * @return imagePullSecret
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Credentials to use for OCI image pulling.")

  public String getImagePullSecret() {
    return imagePullSecret;
  }


  public void setImagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
  }


  public V1alpha1WasmPluginSpec match(List<V1alpha1WasmPluginSpecMatch> match) {
    
    this.match = match;
    return this;
  }

  public V1alpha1WasmPluginSpec addMatchItem(V1alpha1WasmPluginSpecMatch matchItem) {
    if (this.match == null) {
      this.match = new ArrayList<>();
    }
    this.match.add(matchItem);
    return this;
  }

   /**
   * Specifies the criteria to determine which traffic is passed to WasmPlugin.
   * @return match
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the criteria to determine which traffic is passed to WasmPlugin.")

  public List<V1alpha1WasmPluginSpecMatch> getMatch() {
    return match;
  }


  public void setMatch(List<V1alpha1WasmPluginSpecMatch> match) {
    this.match = match;
  }


  public V1alpha1WasmPluginSpec phase(PhaseEnum phase) {
    
    this.phase = phase;
    return this;
  }

   /**
   * Determines where in the filter chain this &#x60;WasmPlugin&#x60; is to be injected.
   * @return phase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines where in the filter chain this `WasmPlugin` is to be injected.")

  public PhaseEnum getPhase() {
    return phase;
  }


  public void setPhase(PhaseEnum phase) {
    this.phase = phase;
  }


  public V1alpha1WasmPluginSpec pluginConfig(Object pluginConfig) {
    
    this.pluginConfig = pluginConfig;
    return this;
  }

   /**
   * The configuration that will be passed on to the plugin.
   * @return pluginConfig
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The configuration that will be passed on to the plugin.")

  public Object getPluginConfig() {
    return pluginConfig;
  }


  public void setPluginConfig(Object pluginConfig) {
    this.pluginConfig = pluginConfig;
  }


  public V1alpha1WasmPluginSpec pluginName(String pluginName) {
    
    this.pluginName = pluginName;
    return this;
  }

   /**
   * Get pluginName
   * @return pluginName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPluginName() {
    return pluginName;
  }


  public void setPluginName(String pluginName) {
    this.pluginName = pluginName;
  }


  public V1alpha1WasmPluginSpec priority(Object priority) {
    
    this.priority = priority;
    return this;
  }

   /**
   * Determines ordering of &#x60;WasmPlugins&#x60; in the same &#x60;phase&#x60;.
   * @return priority
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines ordering of `WasmPlugins` in the same `phase`.")

  public Object getPriority() {
    return priority;
  }


  public void setPriority(Object priority) {
    this.priority = priority;
  }


  public V1alpha1WasmPluginSpec selector(V1alpha3DestinationRuleSpecWorkloadSelector selector) {
    
    this.selector = selector;
    return this;
  }

   /**
   * Get selector
   * @return selector
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public V1alpha3DestinationRuleSpecWorkloadSelector getSelector() {
    return selector;
  }


  public void setSelector(V1alpha3DestinationRuleSpecWorkloadSelector selector) {
    this.selector = selector;
  }


  public V1alpha1WasmPluginSpec sha256(String sha256) {
    
    this.sha256 = sha256;
    return this;
  }

   /**
   * SHA256 checksum that will be used to verify Wasm module or OCI container.
   * @return sha256
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "SHA256 checksum that will be used to verify Wasm module or OCI container.")

  public String getSha256() {
    return sha256;
  }


  public void setSha256(String sha256) {
    this.sha256 = sha256;
  }


  public V1alpha1WasmPluginSpec url(String url) {
    
    this.url = url;
    return this;
  }

   /**
   * URL of a Wasm module or OCI container.
   * @return url
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "URL of a Wasm module or OCI container.")

  public String getUrl() {
    return url;
  }


  public void setUrl(String url) {
    this.url = url;
  }


  public V1alpha1WasmPluginSpec verificationKey(String verificationKey) {
    
    this.verificationKey = verificationKey;
    return this;
  }

   /**
   * Get verificationKey
   * @return verificationKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getVerificationKey() {
    return verificationKey;
  }


  public void setVerificationKey(String verificationKey) {
    this.verificationKey = verificationKey;
  }


  public V1alpha1WasmPluginSpec vmConfig(V1alpha1WasmPluginSpecVmConfig vmConfig) {
    
    this.vmConfig = vmConfig;
    return this;
  }

   /**
   * Get vmConfig
   * @return vmConfig
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public V1alpha1WasmPluginSpecVmConfig getVmConfig() {
    return vmConfig;
  }


  public void setVmConfig(V1alpha1WasmPluginSpecVmConfig vmConfig) {
    this.vmConfig = vmConfig;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1WasmPluginSpec v1alpha1WasmPluginSpec = (V1alpha1WasmPluginSpec) o;
    return Objects.equals(this.imagePullPolicy, v1alpha1WasmPluginSpec.imagePullPolicy) &&
        Objects.equals(this.imagePullSecret, v1alpha1WasmPluginSpec.imagePullSecret) &&
        Objects.equals(this.match, v1alpha1WasmPluginSpec.match) &&
        Objects.equals(this.phase, v1alpha1WasmPluginSpec.phase) &&
        Objects.equals(this.pluginConfig, v1alpha1WasmPluginSpec.pluginConfig) &&
        Objects.equals(this.pluginName, v1alpha1WasmPluginSpec.pluginName) &&
        Objects.equals(this.priority, v1alpha1WasmPluginSpec.priority) &&
        Objects.equals(this.selector, v1alpha1WasmPluginSpec.selector) &&
        Objects.equals(this.sha256, v1alpha1WasmPluginSpec.sha256) &&
        Objects.equals(this.url, v1alpha1WasmPluginSpec.url) &&
        Objects.equals(this.verificationKey, v1alpha1WasmPluginSpec.verificationKey) &&
        Objects.equals(this.vmConfig, v1alpha1WasmPluginSpec.vmConfig);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imagePullPolicy, imagePullSecret, match, phase, pluginConfig, pluginName, priority, selector, sha256, url, verificationKey, vmConfig);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1WasmPluginSpec {\n");
    sb.append("    imagePullPolicy: ").append(toIndentedString(imagePullPolicy)).append("\n");
    sb.append("    imagePullSecret: ").append(toIndentedString(imagePullSecret)).append("\n");
    sb.append("    match: ").append(toIndentedString(match)).append("\n");
    sb.append("    phase: ").append(toIndentedString(phase)).append("\n");
    sb.append("    pluginConfig: ").append(toIndentedString(pluginConfig)).append("\n");
    sb.append("    pluginName: ").append(toIndentedString(pluginName)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    selector: ").append(toIndentedString(selector)).append("\n");
    sb.append("    sha256: ").append(toIndentedString(sha256)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    verificationKey: ").append(toIndentedString(verificationKey)).append("\n");
    sb.append("    vmConfig: ").append(toIndentedString(vmConfig)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

