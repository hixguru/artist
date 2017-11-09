/*
 * Copyright (C) 2017. Uber Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uber.artist.traits.rx.config

import com.ubercab.artist.traits.rx.config.DefaultArtistRxConfig
import java.util.ServiceLoader

class ArtistRxConfigService private constructor() {

    private val serviceLoader = ServiceLoader.load(ArtistRxConfig::class.java)

    /**
     * Gets the optionally overridden [ArtistRxConfig] implementation or the default.
     *
     * @return The located [ArtistRxConfig] or a default config if not provided.
     */
    fun getArtistRxConfig(): ArtistRxConfig = serviceLoader.asIterable().firstOrNull() ?: DEFAULT_CONFIG

    companion object {
        private val DEFAULT_CONFIG: ArtistRxConfig = DefaultArtistRxConfig()

        fun newInstance(): ArtistRxConfigService = ArtistRxConfigService()
    }
}
