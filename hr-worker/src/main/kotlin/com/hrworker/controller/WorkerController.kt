package com.hrworker.controller

import com.hrworker.entities.domain.Worker
import com.hrworker.entities.repositories.WorkerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/workers"])
class WorkerController(
    private val workerRepository: WorkerRepository
) {

    @GetMapping()
    fun findAll(): ResponseEntity<List<Worker>> {
        val list = this.workerRepository.findAll()
        return ResponseEntity.ok(list)
    }

    @GetMapping(value = ["/{id}"])
    fun findById(
        @PathVariable("id") id: Long
    ): ResponseEntity<Worker> {
        val obj = this.workerRepository.findById(id).get()
        return ResponseEntity.ok(obj)
    }

}