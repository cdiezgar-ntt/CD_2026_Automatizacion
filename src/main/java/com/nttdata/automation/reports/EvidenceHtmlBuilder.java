package com.nttdata.automation.reports;

public class EvidenceHtmlBuilder {

    public static String buildEvidenceButtons(String imgBase64, String title) {
        if (imgBase64 == null || imgBase64.isEmpty()) {
            return "";
        }

        String safeTitle = escapeHtml(title);
        String safeFileName = sanitizeFileName(title);
        String dataUrl = normalizeBase64DataUrl(imgBase64);

        return """
        <div class="row mb-3">
            <div class="col-md-3">
                <div class="d-flex gap-2">
                    <a href="%s" data-featherlight="image"
                       class="btn btn-primary btn-sm">
                        🔍 Ver evidencia
                    </a>
                    <a href="%s" download="%s.png"
                       class="btn btn-success btn-sm">
                        ⬇ Descargar
                    </a>
                </div>
            </div>
        </div>
        """.formatted(
                dataUrl,
                dataUrl,
                safeFileName);
    }

    private static String normalizeBase64DataUrl(String imgBase64) {
        if (imgBase64.startsWith("data:image")) {
            return imgBase64;
        }

        return "data:image/png;base64," + imgBase64;
    }

    private static String sanitizeFileName(String value) {
        if (value == null || value.trim().isEmpty()) {
            return "evidencia";
        }

        return value.replaceAll("[^a-zA-Z0-9._-]", "_");
    }

    private static String escapeHtml(String value) {
        if (value == null) {
            return "Evidencia";
        }

        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}