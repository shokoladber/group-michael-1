import React, { useEffect, useState } from "react";

// Create a context to manage the script loading state
const CloudinaryScriptContext = React.createContext();

function UploadWidget() {
  const [loaded, setLoaded] = useState(false);

  useEffect(() => {
    // Check if the script is already loaded
    if (!loaded) {
      const uwScript = document.getElementById("uw");
      if (!uwScript) {
        // If not loaded, create and load the script
        const script = document.createElement("script");
        script.setAttribute("async", "");
        script.setAttribute("id", "uw");
        script.src = "https://upload-widget.cloudinary.com/global/all.js";
        script.addEventListener("load", () => setLoaded(true));
        document.body.appendChild(script);
      } else {
        // If already loaded, update the state
        setLoaded(true);
      }
    }
  }, [loaded]);

  const initializeCloudinaryWidget = () => {
    if (loaded) {
      // Initialize Cloudinary widget or perform any other actions here
      const cloudName = "hzxyensd5"; // replace with your own cloud name
      const uploadPreset = "aoh4fpwm"; // replace with your own upload preset

      // Remove the comments from the code below to add
      // additional functionality.
      // Note that these are only a few examples, to see
      // the full list of possible parameters that you
      // can add see:
      //   https://cloudinary.com/documentation/upload_widget_reference

      var myWidget = window.cloudinary.createUploadWidget(
        {
          cloudName: cloudName,
          uploadPreset: uploadPreset,
          cropping: true, //add a cropping step
          sources: [ "local", "url"], // restrict the upload sources to URL and local files
          multiple: false,  //restrict upload to a single file
          // folder: "user_images", //upload files to the specified folder
          // tags: ["users", "profile"], //add the given tags to the uploaded files
          // context: {alt: "user_uploaded"}, //add the given context data to the uploaded files
          clientAllowedFormats: ["png", "jpeg"],
          // maxImageFileSize: 2000000,  //restrict file size to less than 2MB
          croppingAspectRatio: 1,
          maxImageHeight: 400,
          maxImageWidth: 400, //Scales the image down to a width of 400 pixels before uploading
          // theme: "purple", //change to a purple theme
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log("Done! Here is the image info: ", result.info);
            document
              .getElementById("uploadedimage")
              .setAttribute("src", result.info.secure_url);
          }
        }
      );

      document.getElementById("upload_widget").addEventListener(
        "click",
        function () {
          myWidget.open();
        },
        false
      );
    }
  };

  return (
    <CloudinaryScriptContext.Provider value={{ loaded }}>
      <button
        id="upload_widget"
        className="cloudinary-button"
        onClick={initializeCloudinaryWidget}
      >
        Upload
      </button>
    </CloudinaryScriptContext.Provider>
  );
}

export default UploadWidget;
export { CloudinaryScriptContext };
