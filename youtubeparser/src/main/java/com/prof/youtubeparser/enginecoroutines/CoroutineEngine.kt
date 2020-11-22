/*
*   Copyright 2019 Marco Gomiero
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*
*/

package com.prof.youtubeparser.enginecoroutines

import com.prof.youtubeparser.core.CoreJsonFetcher
import com.prof.youtubeparser.core.CoreJsonParser
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal object CoroutineEngine {

    @Throws(Exception::class)
    suspend fun fetchJson(url: String) =
            withContext(Dispatchers.IO) {
                return@withContext CoreJsonFetcher.fetchJson(url)
            }

    @Throws(Exception::class)
    suspend fun parseVideo(json: Deferred<String>) =
            withContext(Dispatchers.IO) {
                return@withContext CoreJsonParser.parseVideo(json.await())
            }

    @Throws(Exception::class)
    suspend fun parseStats(json: Deferred<String>) =
            withContext(Dispatchers.IO) {
                return@withContext CoreJsonParser.parseStats(json.await())
            }

}