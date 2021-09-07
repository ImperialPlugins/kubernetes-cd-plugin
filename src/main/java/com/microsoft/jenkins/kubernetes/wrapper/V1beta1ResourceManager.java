/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.jenkins.kubernetes.wrapper;

import com.microsoft.jenkins.kubernetes.util.Constants;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.BatchV1beta1Api;
import io.kubernetes.client.openapi.apis.ExtensionsV1beta1Api;
import io.kubernetes.client.openapi.apis.NetworkingV1beta1Api;
import io.kubernetes.client.openapi.models.NetworkingV1beta1Ingress;
import io.kubernetes.client.openapi.models.V1Status;
import io.kubernetes.client.openapi.models.V1beta1CronJob;
import io.kubernetes.client.openapi.models.ExtensionsV1beta1Ingress;

import static com.google.common.base.Preconditions.checkNotNull;

public class V1beta1ResourceManager extends ResourceManager {
    private final ExtensionsV1beta1Api extensionsV1beta1Api;
    private final BatchV1beta1Api batchV1beta1Api;
    private final NetworkingV1beta1Api networkingV1beta1Api;
    private V1beta1ResourceUpdateMonitor resourceUpdateMonitor = V1beta1ResourceUpdateMonitor.NOOP;

    public V1beta1ResourceManager(ApiClient client) {
        super(true);
        checkNotNull(client);
        extensionsV1beta1Api = new ExtensionsV1beta1Api(client);
        batchV1beta1Api = new BatchV1beta1Api(client);
        networkingV1beta1Api = new NetworkingV1beta1Api(client);
    }

    public V1beta1ResourceManager(ApiClient client, boolean pretty) {
        super(pretty);
        checkNotNull(client);
        extensionsV1beta1Api = new ExtensionsV1beta1Api(client);
        batchV1beta1Api = new BatchV1beta1Api(client);
        networkingV1beta1Api = new NetworkingV1beta1Api(client);
    }

    public V1beta1ResourceUpdateMonitor getResourceUpdateMonitor() {
        return resourceUpdateMonitor;
    }

    public V1beta1ResourceManager withResourceUpdateMonitor(V1beta1ResourceUpdateMonitor monitor) {
        checkNotNull(monitor);
        this.resourceUpdateMonitor = monitor;
        return this;
    }

    class ExtensionsIngressUpdater extends ResourceUpdater<ExtensionsV1beta1Ingress> {
        ExtensionsIngressUpdater(ExtensionsV1beta1Ingress ingress) {
            super(ingress);
        }

        @Override
        ExtensionsV1beta1Ingress getCurrentResource() {
            ExtensionsV1beta1Ingress ingress = null;
            try {
                ingress = extensionsV1beta1Api.readNamespacedIngress(getName(), getNamespace(), getPretty(),
                        true, true);
            } catch (ApiException e) {
                handleApiExceptionExceptNotFound(e);
            }
            return ingress;
        }

        @Override
        ExtensionsV1beta1Ingress applyResource(ExtensionsV1beta1Ingress original, ExtensionsV1beta1Ingress current) {
            ExtensionsV1beta1Ingress ingress = null;
            try {
                ingress = extensionsV1beta1Api.replaceNamespacedIngress(getName(), getNamespace(), current,
                        getPretty(), null, null);
            } catch (ApiException e) {
                handleApiException(e);
            }
            return ingress;
        }

        @Override
        ExtensionsV1beta1Ingress createResource(ExtensionsV1beta1Ingress current) {
            ExtensionsV1beta1Ingress ingress = null;
            try {
                ingress = extensionsV1beta1Api.createNamespacedIngress(getNamespace(),
                        current, getPretty(), null, null);
            } catch (ApiException e) {
                handleApiException(e);
            }
            return ingress;
        }

        @Override
        Object deleteResource(ExtensionsV1beta1Ingress current) {
            V1Status result = null;
            try {
                result = extensionsV1beta1Api.deleteNamespacedIngress(
                        getName(), getNamespace(),
                        getPretty(), null, null, null, null, Constants.BACKGROUND_DELETEION);
            } catch (ApiException e) {
                handleApiExceptionExceptNotFound(e);
            }
            return result;
        }


        @Override
        void notifyUpdate(ExtensionsV1beta1Ingress original, ExtensionsV1beta1Ingress current) {
            resourceUpdateMonitor.onExtensionsIngressUpdate(original, current);
        }
    }

    class NetworkingIngressUpdater extends ResourceUpdater<NetworkingV1beta1Ingress> {
        NetworkingIngressUpdater(NetworkingV1beta1Ingress ingress) {
            super(ingress);
        }

        @Override
        NetworkingV1beta1Ingress getCurrentResource() {
            NetworkingV1beta1Ingress ingress = null;
            try {
                ingress = networkingV1beta1Api.readNamespacedIngress(getName(), getNamespace(), getPretty(),
                        true, true);
            } catch (ApiException e) {
                handleApiExceptionExceptNotFound(e);
            }
            return ingress;
        }

        @Override
        NetworkingV1beta1Ingress applyResource(NetworkingV1beta1Ingress original, NetworkingV1beta1Ingress current) {
            NetworkingV1beta1Ingress ingress = null;
            try {
                ingress = networkingV1beta1Api.replaceNamespacedIngress(getName(), getNamespace(), current,
                        getPretty(), null, null);
            } catch (ApiException e) {
                handleApiException(e);
            }
            return ingress;
        }

        @Override
        NetworkingV1beta1Ingress createResource(NetworkingV1beta1Ingress current) {
            NetworkingV1beta1Ingress ingress = null;
            try {
                ingress = networkingV1beta1Api.createNamespacedIngress(getNamespace(),
                        current, getPretty(), null, null);
            } catch (ApiException e) {
                handleApiException(e);
            }
            return ingress;
        }

        @Override
        Object deleteResource(NetworkingV1beta1Ingress current) {
            V1Status result = null;
            try {
                result = networkingV1beta1Api.deleteNamespacedIngress(
                        getName(), getNamespace(),
                        getPretty(), null, null, null, null, Constants.BACKGROUND_DELETEION);
            } catch (ApiException e) {
                handleApiExceptionExceptNotFound(e);
            }
            return result;
        }


        @Override
        void notifyUpdate(NetworkingV1beta1Ingress original, NetworkingV1beta1Ingress current) {
            resourceUpdateMonitor.onNetworkingIngressUpdate(original, current);
        }
    }

    class CronJobUpdater extends ResourceUpdater<V1beta1CronJob> {
        CronJobUpdater(V1beta1CronJob namespace) {
            super(namespace);
        }

        @Override
        V1beta1CronJob getCurrentResource() {
            V1beta1CronJob result = null;
            try {
                result = batchV1beta1Api.readNamespacedCronJob(
                        getName(), getNamespace(), getPretty(), true, true);
            } catch (ApiException e) {
                handleApiExceptionExceptNotFound(e);
            }
            return result;
        }

        @Override
        V1beta1CronJob applyResource(V1beta1CronJob original, V1beta1CronJob current) {
            V1beta1CronJob result = null;
            try {
                result = batchV1beta1Api.replaceNamespacedCronJob(
                        getName(), getNamespace(), current, getPretty(), null, null);
            } catch (ApiException e) {
                handleApiException(e);
            }
            return result;
        }

        @Override
        V1beta1CronJob createResource(V1beta1CronJob current) {
            V1beta1CronJob result = null;
            try {
                result = batchV1beta1Api.createNamespacedCronJob(
                        getNamespace(), current, getPretty(), null, null);
            } catch (ApiException e) {
                handleApiException(e);
            }
            return result;
        }

        @Override
        Object deleteResource(V1beta1CronJob current) {
            V1Status result = null;
            try {
                result = batchV1beta1Api.deleteNamespacedCronJob(
                        getName(), getNamespace(),
                        getPretty(), null, null, null, null, Constants.BACKGROUND_DELETEION);
            } catch (ApiException e) {
                handleApiExceptionExceptNotFound(e);
            }
            return result;
        }

        @Override
        void notifyUpdate(V1beta1CronJob original, V1beta1CronJob current) {
            resourceUpdateMonitor.onCronJobUpdate(original, current);
        }
    }

}
