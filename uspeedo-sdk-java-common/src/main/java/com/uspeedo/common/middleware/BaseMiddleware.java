/**
 * Copyright 2021 USpeedo Technology Co., Ltd.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.uspeedo.common.middleware;

import com.uspeedo.common.exception.USpeedoException;
import com.uspeedo.common.request.Request;
import com.uspeedo.common.response.Response;

public abstract class BaseMiddleware implements Middleware {

    @Override
    public Request handleRequest(Context context) throws USpeedoException {
        return context.getRequest();
    }

    @Override
    public Response handleResponse(Context context) throws USpeedoException {
        return context.getResponse();
    }

    @Override
    public void handleException(Context context) throws USpeedoException {}
}
