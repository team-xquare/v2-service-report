package com.xquare.v2servicereport.common.feign.client

import com.xquare.v2servicereport.user.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@FeignClient(name = "UserClient", url = "\${service.scheme}://\${service.user.host}")
interface UserClient {

    @GetMapping("/users/id/{userId}")
    fun getUserByUserId(@PathVariable("userId") userId: UUID): User
}
