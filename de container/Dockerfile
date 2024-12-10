FROM mcr.microsoft.com/vscode/devcontainers/java:0-8

# Install Android SDK and other dependencies
RUN apt-get update && apt-get install -y --no-install-recommends \
    android-sdk \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# Set environment variables for Android SDK
ENV ANDROID_HOME=/usr/lib/android-sdk
ENV PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
