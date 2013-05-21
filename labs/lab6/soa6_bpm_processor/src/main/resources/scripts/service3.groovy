
println "3********** Begin Service 3 ***********"

println "In: " + request.getBody()

request.setBody("Service 3 " + exchange.getIn().getBody())

println "Out: " + request.getBody()

println "************ End Service 3 ************"

return request.getBody()
