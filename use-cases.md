USE Case: Produce a report on the percentage population that speaks a given language 

Goal in Context: As a language tutor I want to be able to find out what percentage of the population speaks Hindi so I can premote my language courses

Preconditions: We know the role. The Database contains data on languages

Success End Condition: A report is produced with the successful information

Failed End Condition: No report is produced

Actors: Language tutor

Trigger: A request for language information is requested

Main Success Scenerio: Requests language information for a given language
                       Language tutor captures name of the language to get language information
                       Language tutor extracts current language information of a given language
                       Language tutor provides report

Extensions: Language does not exist: Language tutor informs Head of department that Language does not exist

Schedule: Due Date: Release Unkown

---------------------------------------------

USE Case: Produce a report on the population of a country 

Goal in Context: As a UN Worker I want to be able to find out the population of every country in the world 

Preconditions: We know the role. The Database contains data on the population of all the countries

Success End Condition: A report is produced with the successful information

Failed End Condition: No report is produced

Actors: UN Worker

Trigger: A request for language information is requested

Main Success Scenerio: UN requests population information for the world
                       UN Worker captures name of the population to get population information
                       UN Worker extracts current population information
                       UN Workerprovides report

Extensions: Country does not exist: UN Worker informs the UN that country does not exist

Schedule: Due Date: Release Unkown
