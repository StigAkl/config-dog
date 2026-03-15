import { SignIn, SignedIn, SignedOut } from "@clerk/clerk-react";
import { createFileRoute, Navigate } from "@tanstack/react-router";

export const Route = createFileRoute("/sign-in")({
	component: SignInPage,
});

function SignInPage() {
	return (
		<main className="page-wrap px-4 py-12">
			<SignedIn>
				<Navigate to="/" />
			</SignedIn>
			<SignedOut>
				<section className="mx-auto max-w-5xl">
					<div className="grid gap-8 rounded-3xl border border-(--line) bg-(--surface) p-5 shadow-[0_24px_60px_rgba(18,64,58,0.12)] sm:p-8 md:grid-cols-[1.1fr_1fr]">
						<div className="space-y-4 rounded-2xl border border-(--line) bg-(--chip-bg) p-6">
							<p className="text-sm font-semibold uppercase tracking-[0.18em] text-(--kicker)">
								Welcome back
							</p>
							<h1 className="m-0 text-3xl font-extrabold tracking-tight text-sea-ink sm:text-4xl">
								Sign in to ConfigDog
							</h1>
							<p className="m-0 text-base text-sea-ink-soft">
								Continue where you left off and manage your feature toggles.
							</p>
						</div>
						<div className="flex items-center justify-center">
							<SignIn
								path="/sign-in"
								routing="path"
								forceRedirectUrl="/"
								appearance={{
									variables: {
										colorPrimary: "var(--lagoon-deep)",
										colorText: "var(--sea-ink)",
										colorTextSecondary: "var(--sea-ink-soft)",
										colorBackground: "transparent",
										colorInputBackground: "var(--surface-strong)",
										colorInputText: "var(--sea-ink)",
										borderRadius: "1rem",
									},
									elements: {
										rootBox: "w-full",
										cardBox: "w-full",
										card: "w-full border border-(--line) bg-(--surface-strong) shadow-[0_20px_45px_rgba(19,58,53,0.16)]",
										headerTitle: "text-sea-ink",
										headerSubtitle: "text-sea-ink-soft",
										formButtonPrimary:
											"bg-(--lagoon-deep) hover:bg-(--lagoon) text-white shadow-none",
										footerActionLink: "text-(--lagoon-deep) hover:text-(--lagoon)",
										formFieldInput:
											"border border-(--line) bg-(--surface-strong) text-sea-ink",
									},
								}}
							/>
						</div>
					</div>
				</section>
			</SignedOut>
		</main>
	);
}
