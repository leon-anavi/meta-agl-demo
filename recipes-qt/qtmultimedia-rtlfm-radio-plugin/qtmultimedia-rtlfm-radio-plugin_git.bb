SUMMARY = "QtMultimedia RTL-SDR Radio Plugin"
DESCRIPTION = "QtMultimedia RTL-SDR Radio Plugin"
HOMEPAGE = "https://gerrit.automotivelinux.org/gerrit/#/admin/projects/staging/qtmultimedia-rtlfm-radio-plugin"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://rtlfmradioplugin.cpp;endline=5;md5=747a800420eac5cb6ab2cb85514d88b2"

DEPENDS = "qtmultimedia pulseaudio"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/qtmultimedia-rtlfm-radio-plugin;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit qmake5

FILES_${PN} += "${OE_QMAKE_PATH_PLUGINS}/mediaservice/*.so"
FILES_${PN}-dbg += "${OE_QMAKE_PATH_PLUGINS}/mediaservice/.debug"

RDEPENDS_${PN} = "rtl-sdr alsa-utils-aplay"
