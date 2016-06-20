SUMMARY = "AGL Demo Platform with OSTree and GENIVI SOTA Project"

DESCRIPTION = "AGL demo platform with OSTree and GENIVI SOTA project."

require agl-demo-platform.bb

IMAGE_INSTALL_append = "ostree rvi-sota-client"

inherit sota-contents
