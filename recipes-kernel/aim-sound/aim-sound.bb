DESCRIPTION = "Build ALSA driver for MOST"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
DEPENDS = " mostcore"

inherit module

PV = "0.1"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/most;protocol=https"
SRC_URI_append_porter = " file://0001-aim-sound-3.10.31-ltsi-backport.patch"

S = "${WORKDIR}/git/driver/${PN}"
SRCREV = "${AUTOREV}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

do_install_append () {
    # modprobe automatically at boot
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${sysconfdir}/modules-load.d
        echo "aim_sound" > ${D}${sysconfdir}/modules-load.d/aim_sound.conf
    fi
}
