FROM clojure
RUN mkdir -p /usr/app
WORKDIR /usr/app
COPY project.clj /usr/app/
RUN lein deps
COPY . /usr/app
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar
EXPOSE 8080
CMD ["java", "-jar", "app-standalone.jar"]
