import hudson.model.*;

// get all jobs which exists    
jobs = Hudson.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob)

// iterate through the jobs
for (job in jobs) {
  // define a pattern, which jobs I want to run
  def pattern = 'maven_test_'
  def p_match = job.getName() =~ pattern
  
  // if pattern match, then run the job
  if (p_match) {
    // first check, if job is buildable
    if (job instanceof BuildableItem) {
      // run that job
      job.scheduleBuild()
    }
  }
}
