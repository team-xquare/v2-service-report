package com.xquare.v2servicereport.common.feign.client

import org.springframework.cloud.openfeign.FeignClient

@FeignClient(name = "UserClient", url = "\${service.scheme}://\${service.user.host}")
interface UserClient
