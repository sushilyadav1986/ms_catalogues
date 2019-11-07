# Start with a base image containing Java runtime
From openjdk:8
#copying of files into the container
COPY ./target/ms_catalogue.jar ms_catalogue.jar
# CMD sets default command and/or parameters, which can be overwritten from command line when docker container runs.
CMD ["java","-jar","ms_catalogue.jar"]