# Bankaccount app
### To launch docker image run the following steps:
- [ ] Gradle build
- [ ] Make sure that docker is launched on your system
- [ ] docker build --build-arg JAR_FILE=build/libs/\*.jar -t bankaccount .
- [ ] docker-compose up -d
  - [ ] To see docker's logs docker logs backend -f
  - [ ] To stop, delete docker and postgres 'docker-compose down'
> Make sure pg_hba conf access, and create bank_db databases in docker's pg instance
### To launch spring boot app locally:
- [ ] In application.yaml:3 change host from postgres to localhost/"host where postgres server runs"
> Mockk Unit test was commented due to the my laptop's system namings "Пользователь" several operations was rejected

### Documentation is on http://localhost:8080/swagger-ui/index.html