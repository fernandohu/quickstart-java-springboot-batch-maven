FROM maven:3-jdk-12
RUN yum -y install curl zip unzip sed which
RUN curl -s "https://get.sdkman.io" | bash
RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install springboot"
RUN ln -s /root/.sdkman/candidates/springboot/current/bin/spring /usr/bin/spring
EXPOSE 8080
VOLUME /app
WORKDIR /app
CMD mvn spring-boot:run