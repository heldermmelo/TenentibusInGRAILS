package br.net.tenentibus



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured;
@Secured(["hasAnyRole('ROLE_ADMIN','ROLE_SINDICO') and isFullyAuthenticated()"])
@Transactional(readOnly = true)
class BlocoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Bloco.list(params), model:[blocoInstanceCount: Bloco.count()]
    }

    def show(Bloco blocoInstance) {
        respond blocoInstance
    }

    def create() {
        respond new Bloco(params)
    }

    @Transactional
    def save(Bloco blocoInstance) {
        if (blocoInstance == null) {
            notFound()
            return
        }

        if (blocoInstance.hasErrors()) {
            respond blocoInstance.errors, view:'create'
            return
        }

        blocoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bloco.label', default: 'Bloco'), blocoInstance.id])
                redirect blocoInstance
            }
            '*' { respond blocoInstance, [status: CREATED] }
        }
    }

    def edit(Bloco blocoInstance) {
        respond blocoInstance
    }

    @Transactional
    def update(Bloco blocoInstance) {
        if (blocoInstance == null) {
            notFound()
            return
        }

        if (blocoInstance.hasErrors()) {
            respond blocoInstance.errors, view:'edit'
            return
        }

        blocoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Bloco.label', default: 'Bloco'), blocoInstance.id])
                redirect blocoInstance
            }
            '*'{ respond blocoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Bloco blocoInstance) {

        if (blocoInstance == null) {
            notFound()
            return
        }

        blocoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Bloco.label', default: 'Bloco'), blocoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bloco.label', default: 'Bloco'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
