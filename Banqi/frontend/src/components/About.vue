<template>
    <div name="about">
      <b-container class="aboutPageContent">
        <b-row>
          <b-col class="center"><h1>About Hackers Anonymous</h1></b-col>
        </b-row>
        <br/>
        <b-row class="text-center  justify-content-md-center">
          <b-col md="auto">
            <b-card title="Evan Lavertu"
                    style="max-width: 20rem;"
                    class="mb-2 aboutCards">
              <img src="../images/Lavertu.png" class="restrict-size"/>
              <b-card-text>
                Evan Lavertu is currently pursuing a degree in Computer Science at Colorado State University (CSU).
                He currently works for Engineering Technology Services at CSU providing technical support to the College of Engineering.
                He also works as a Undergraduate Research Assistant for the IoT Lab in the Computer Science Department.
                Evan is eager to enter the field of Computer Science, with interest in Cyber Security and Software Development.
                In his free time he enjoys playing video games and spending time with his dog, Sudo.
              </b-card-text>
            </b-card>
          </b-col>
          <b-col md="auto">
            <b-card title="Cody Coleman"
                    style="max-width: 20rem;"
                    class="mb-2 aboutCards">
              <img src="../images/cody.png" class="restrict-size"/>
              <b-card-text>
                Cody Coleman is a Junior at Colorado State University and working on
                completing his degree in Computer Science (CS). Interests in the field of
                CS include Cyber Security, CryptoCurrency, and Distributed Systems.
                He is also a member of the Colorado Air National Guard as a maintainer
                on the F-16 Fighting Falcons. His hobbies include snowboarding, basketball,
                volleyball, and spending time with his wife Kathryn, and pup Jett.
              </b-card-text>
            </b-card>
          </b-col>
        </b-row>
        <br/>
        <b-row class="text-center">
          <b-col>
            <b-card title="Patrick Keleher"
                    style="max-width: 20rem;"
                    class="mb-2 aboutCards">
              <img src="../images/patrick.png" class="restrict-size"/>
              <b-card-text>
                Patrick is a Senior in Computer Science. His interests are in cyber security and networking.
                Some of his hobbies include hiking, snowboarding, and playing video games.
                He is from Crawford, Colorado.
              </b-card-text>
            </b-card>
          </b-col>
          <b-col>
            <b-card title="Kareem Youssef"
                    style="max-width: 20rem;"
                    class="mb-2 aboutCards">
              <img src="../images/kareem.jpg" class="restrict-size"/>
              <b-card-text>
                Kareem is a senior computer science Major, he's interested in Virtual/augmented reality tech and their use cases.
                In his free time he likes playing video games, going on hikes, camping or just doing anything outside.
              </b-card-text>
            </b-card>
          </b-col>
          <b-col>
            <b-card title="Jack Fitzgerald"
                    style="max-width: 20rem;"
                    class="mb-2 aboutCards">
              <img src="../images/jack.jpeg" class="restrict-size"/>
              <b-card-text>
                Jack is a senior at CSU studying Computer Science, his current interests are in AI, networking and cyber security.
                Jack has recently attended his first CTF event with the members of this team, as well as a virtual reality hackathon.
                He also enjoys snowboarding and playing video games when he gets the chance.
              </b-card-text>
            </b-card>
          </b-col>
        </b-row>
        <br/>
      </b-container>
    </div>
</template>

<script>
    export default {
        name: "About"
    }
</script>

<style scoped>
  .restrict-size {
    width: 50%;
    height: 50%;
  }

  .center {
    text-align: center;
  }

  .aboutCards {
    box-shadow: 10px 10px 5px grey;
  }

</style>
