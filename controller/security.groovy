import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin","Password1234")
instance.setSecurityRealm(hudsonRealm)

// needs matrix-auth Plugin
def strategy = new GlobalMatrixAuthorizationStrategy()
strategy.add(Jenkins.ADMINISTER, "admin")
instance.setAuthorizationStrategy(strategy)
instance.save()

// for more elaborate matrix 
// https://github.com/cloudbees/jenkins-scripts/blob/master/RBAC_Example.groovy

