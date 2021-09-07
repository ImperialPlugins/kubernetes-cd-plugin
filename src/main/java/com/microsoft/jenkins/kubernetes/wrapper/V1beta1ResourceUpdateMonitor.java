/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.jenkins.kubernetes.wrapper;

import io.kubernetes.client.openapi.models.NetworkingV1beta1Ingress;
import io.kubernetes.client.openapi.models.V1beta1CronJob;
import io.kubernetes.client.openapi.models.ExtensionsV1beta1Ingress;

public interface V1beta1ResourceUpdateMonitor {

    V1beta1ResourceUpdateMonitor NOOP = new Adapter();

    void onExtensionsIngressUpdate(ExtensionsV1beta1Ingress original, ExtensionsV1beta1Ingress current);

    void onNetworkingIngressUpdate(NetworkingV1beta1Ingress original, NetworkingV1beta1Ingress current);

    void onCronJobUpdate(V1beta1CronJob original, V1beta1CronJob current);

    class Adapter implements V1beta1ResourceUpdateMonitor {
        @Override
        public void onExtensionsIngressUpdate(ExtensionsV1beta1Ingress original, ExtensionsV1beta1Ingress current) {
        }

        @Override
        public void onNetworkingIngressUpdate(NetworkingV1beta1Ingress original, NetworkingV1beta1Ingress current) {
        }

        @Override
        public void onCronJobUpdate(V1beta1CronJob original, V1beta1CronJob current) {
        }
    }
}
