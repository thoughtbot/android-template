# Environment Setup which is required for Circle CI

function copy_env_vars_to_gradle_properties {
    GRADLE_PROPERTIES=$HOME"/.gradle/gradle.properties"
    export GRADLE_PROPERTIES

    // echo "Writing API_CLIENT_ID to gradle.properties..."
    //echo "API_CLIENT_ID=$API_CLIENT_ID" >> "$GRADLE_PROPERTIES"

}

function affirmative_android_update {
  echo y | android update sdk --no-ui --all --filter "$1"
}

function get_android_sdk {
  # fix the CircleCI path
  # export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$PATH"

  DEPS="$ANDROID_HOME/installed-dependencies"

  if [ ! -e $DEPS ]; then
    echo Updating SDK
    echo y | android update sdk --no-ui --all --filter tool,extra-android-m2repository,extra-android-support,extra-google-google_play_services,extra-google-m2repository
    # get the newest build tools
    echo y | android update sdk --no-ui --all --filter build-tools-23.0.3
    # create avd of our min sdk version for connected testing
    echo no | android create avd -n testAVD -f -t android-19 --abi default/armeabi-v7a
    # create the folder so we won't do this again (this is soooo Apache Ant right here)
    touch $DEPS
  fi
}
