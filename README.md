# Bankaccount app
### To launch docker image run the following steps:
- [ ] Gradle build
- [ ] Make sure that docker is launched on your system
- [ ] docker build --build-arg JAR_FILE=build/libs/\*.jar -t bankaccount .
- [ ] docker-compose up -d
  - [ ] To see docker's logs docker logs backend -f
  - [ ] To stop docker 'docker stop backend'
  - [ ] To stop postgres in docker 'docker stop postgres'
### Make sure pg_hba conf access, and create bank_db databases in dockers database
### Mockk Unit test was commented due to the my laptop's system namings "Пользователь" several operations was rejected
