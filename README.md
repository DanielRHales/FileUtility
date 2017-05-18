<!DOCTYPE html>
<html>
<body>

<u><a style="color: #82198c;" title="Toggle Developer Credits" onclick="toggleDevelopers()">Developers Credits</a></u>
<br>

<ul id="developersList" style="display: none;">
    <li>
        <div>Daniel (DRHales)</div>
    </li>
</ul>

<u><a style="color: #82198c;" title="Toggle Graphical Credits" onclick="toggleGraphics()">Graphical Credits</a></u>
<br>

<ul id="graphicsList" style="display: none;">
    <li>
        <div>General Icons at <a href="https://www.google.com/" title="Google">Google</a></div>
    </li>
    <li>
        <div>General Icons at <a href="https://www.flaticon.com/" title="Flat Icon">Flat Icon</a></div>
    </li>
    <li>
        <div>Tab Icons at <a href="https://github.com/teambox/Free-file-icons" title="Free-file-icons">teambox</a></div>
    </li>
    <li></li>
    <li>
        <div>Icons made by <a href="http://www.flaticon.com/authors/madebyoliver" title="Madebyoliver">Madebyoliver</a>
            from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a
                    href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC
                3.0 BY</a></div>
    </li>
    <li>
        <div>Icons made by <a href="http://www.flaticon.com/authors/creaticca-creative-agency"
                              title="Creaticca Creative Agency">Creaticca Creative Agency</a> from <a
                href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a
                href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC
            3.0 BY</a></div>
    </li>
    <li>
        <div>Icons made by <a href="http://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel
            perfect</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a
                href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC
            3.0 BY</a></div>
    </li>
    <li>
        <div>Icons made by <a href="http://www.flaticon.com/authors/prosymbols" title="Prosymbols">Prosymbols</a> from
            <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a
                    href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC
                3.0 BY</a></div>
    </li>
</ul>

<u><a style="color: #82198c;" title="Toggle Library Credits" onclick="toggleLibraries()">Library Credits</a></u>
<br>

<ul id="libraryList" style="display: none;">
    <li>
        <div>Developers of GSON</div>
    </li>
    <li>
        <div>Developers of Substance</div>
    </li>
</ul>

<script language="JavaScript">

    toggleDevelopers = function () {
        toggle("developersList");
    };

    toggleGraphics = function () {
        toggle("graphicsList");
    };

    toggleLibraries = function () {
        toggle("libraryList");
    };

    toggle = function (element) {
        var x = document.getElementById(element);
        if (x.style.display === 'none') {
            x.style.display = 'block';
        } else {
            x.style.display = 'none';
        }
    };

</script>

</body>
</html>