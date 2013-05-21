
println "1********** Begin Service 1 ***********"

println "In: " + request.getBody()

request.setBody("Service 1 " + exchange.getIn().getBody())

println "Out: " + request.getBody()

println "************ End Service 1 ************"

return request.getBody()


