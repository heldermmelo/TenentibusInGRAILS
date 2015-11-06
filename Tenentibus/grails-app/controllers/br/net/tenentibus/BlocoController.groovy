package br.net.tenentibus



import org.springframework.dao.DataIntegrityViolationException

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured("hasAnyRole('ROLE_ADMIN','ROLE_SINDICO')")
@Transactional(readOnly = true)
class BlocoController {

	def quickSearchService
	def searchProperties = null // [:]
	def customCriteria = {}

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 50, 100)

		def list = quickSearchService.search(domainClass: Bloco, searchParams: params,
			searchProperties: searchProperties, query: params.q, customClosure: customCriteria)
		
        respond list, model:[blocoInstanceCount: list.totalCount]
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
                flash.message = message(code: 'default.created.message', encodeAs: 'none', args: [message(code: 'bloco.label', default: 'Bloco'), blocoInstance])
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
                flash.message = message(code: 'default.updated.message', encodeAs: 'none', args: [message(code: 'bloco.label', default: 'Bloco'), blocoInstance])
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

        try {

            blocoInstance.delete flush:true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.deleted.message', encodeAs: 'none', args: [message(code: 'bloco.label', default: 'Bloco'), blocoInstance])
                    redirect action:"index", method:"GET"
                }
                '*'{ render status: NO_CONTENT }
            }

        }catch (DataIntegrityViolationException e){

            request.withFormat {
                form multipartForm {
                    flash.alert = message(code: 'error.violacao.integridade', encodeAs: 'none', args: [message(code: 'bloco.label', default: 'Bloco'), blocoInstance])
                    redirect blocoInstance
                }
            }
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
