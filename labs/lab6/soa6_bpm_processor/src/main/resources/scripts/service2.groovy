
println "2********** Begin Service 2 ***********"

println "In: " + request.getBody()

request.setBody("Service 2 " + exchange.getIn().getBody())

println "Out: " + request.getBody()

println "************ End Service 2 ************"

return request.getBody()
